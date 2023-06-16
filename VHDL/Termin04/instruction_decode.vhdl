library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity instruction_decode is port (
  instruction, pc_in : in std_logic_vector(31 downto 0);
  pc, lit, jumplit : out std_logic_vector(31 downto 0);
  addr_of_rs1, addr_of_rs2, addr_of_rd : out std_logic_vector(4 downto 0);
  aluop : out std_logic_vector(4 downto 0);
  sel_pc_not_rs1, sel_lit_not_rs2, is_jalr : out std_logic;
  cpuclk : in std_logic
); end entity;

architecture a of instruction_decode is
  component d_reg is generic(
    width : natural
  ); port(
    d_in : in std_logic_vector((width-1) downto 0);
    clk : in std_logic;
    d_out : out std_logic_vector((width-1) downto 0)
  ); end component;


  signal sel_vector_1,sel_vector_2 : std_logic_vector(2 downto 0);
  signal id_lit, id_jumplit : std_logic_vector(31 downto 0);
  signal id_addr_of_rs1, id_addr_of_rs2, id_addr_of_rd : std_logic_vector(4 downto 0);
  signal id_aluop : std_logic_vector(4 downto 0);
  signal id_sel_pc_not_rs1, id_sel_lit_not_rs2, id_is_jalr : std_logic;

  signal u_type_lit, j_type_lit, i_type_lit, s_type_lit, b_type_lit : std_logic_vector(31 downto 0);
begin
  u_type_lit(31 downto 12) <= instruction(31 downto 12);
  u_type_lit(11 downto 0) <= (others => '0');

  j_type_lit(31 downto 20) <= (others => instruction(31));
  j_type_lit(19 downto 12) <= instruction(19 downto 12);
  j_type_lit(11) <= instruction(20);
  j_type_lit(10 downto  1) <= instruction(30 downto 21);
  j_type_lit(0) <= '0';

  i_type_lit(31 downto 12) <= (others => instruction(31));
  i_type_lit(11 downto 0) <= instruction(31 downto 20);

  s_type_lit(31 downto 12) <= (others => instruction(31));
  s_type_lit(11 downto 5) <= instruction(31 downto 25);
  s_type_lit(4 downto 0) <= instruction(11 downto 7);

  b_type_lit(31 downto 12) <= (others => instruction(31));
  b_type_lit(11) <= instruction(7);
  b_type_lit(10 downto 5) <= instruction(30 downto 25);
  b_type_lit(4 downto 1) <= instruction(11 downto  8);
  b_type_lit(0) <= '0';

  process(instruction, u_type_lit, j_type_lit, i_type_lit, s_type_lit, b_type_lit)
  begin
    id_addr_of_rs1 <= instruction(19 downto 15);
    id_addr_of_rs2 <= instruction(24 downto 20);
    id_addr_of_rd  <= instruction(11 downto  7);
    id_sel_pc_not_rs1 <= '0';
    id_sel_lit_not_rs2 <= '1';
    id_is_jalr <= '0';
    id_lit <= (others => '0');
    id_jumplit <= (others => '0');
    id_aluop <= "00000";

    case instruction(6 downto 2) is
      when "01101" =>   id_addr_of_rs1 <= "00000"; 
                        id_lit <= u_type_lit;
                        id_sel_lit_not_rs2 <= '1';
      when "00101" =>   id_sel_pc_not_rs1 <= '1';
                        id_sel_lit_not_rs2 <= '1';
                        id_lit <= u_type_lit;
      when "11011" =>   id_sel_pc_not_rs1 <= '1';
                        id_aluop <= "10011";
                        id_jumplit <= j_type_lit;
      when "11001" =>   id_sel_pc_not_rs1 <= '1';
                        id_aluop <= "10011";
                        id_jumplit <= i_type_lit;
                        id_is_jalr <= '1';
      when "11000" =>   id_aluop(4)<='1';
                        id_aluop(3)<='-';
                        id_aluop(2 downto 0)<=instruction(14 downto 12);
                        id_sel_lit_not_rs2 <= '0'; 
                        id_addr_of_rd <= "00000"; 
                        id_jumplit <= b_type_lit;
      when "00100" =>   id_aluop(4)<='0';            
                        id_aluop(4)<='0';
                        id_aluop(3)<=instruction(30);
                        id_aluop(2 downto 0)<=instruction(14 downto 12);
                        if instruction(14 downto 12)/="101" then id_aluop(3)<='0'; end if;
                        id_lit <= i_type_lit;
      when "01100" =>   id_sel_lit_not_rs2 <= '0';
                        id_aluop(4)<='0';
                        id_aluop(3)<=instruction(30);
                        id_aluop(2 downto 0)<=instruction(14 downto 12);
      when others =>
    end case;
  end process;
  sel_vector_1(2) <= id_sel_pc_not_rs1;
  sel_vector_1(1) <= id_sel_lit_not_rs2;
  sel_vector_1(0) <= id_is_jalr;

  id_sel_pc_not_rs1<=  sel_vector_2(2);
  id_sel_lit_not_rs2 <=  sel_vector_2(1);
  id_is_jalr <=  sel_vector_2(0);

  seL_vector_d_reg  : d_reg generic map (width => 3)  port map(sel_vector_1,  cpuclk, sel_vector_2);
  pc_d_reg:d_reg generic map (width => 32) port map(pc_in, cpuclk, pc);
  lit_d_reg:d_reg generic map (width => 32) port map(id_lit, cpuclk, lit);
  jumplit_d_reg:d_reg generic map (width => 32) port map(id_jumplit, cpuclk, jumplit);
  addr_of_rs1_d_reg:d_reg generic map (width => 5)  port map(id_addr_of_rs1, cpuclk, addr_of_rs1);
  addr_of_rs2_d_reg:d_reg generic map (width => 5)  port map(id_addr_of_rs2, cpuclk, addr_of_rs2);
  addr_of_rd_d_rreg:d_reg generic map (width => 5)  port map(id_addr_of_rd, cpuclk, addr_of_rd);
  aluop_d_reg:d_reg generic map (width => 5)  port map(id_aluop, cpuclk, aluop);

end architecture;