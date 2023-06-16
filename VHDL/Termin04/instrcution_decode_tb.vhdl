ghdl -r 'instruction_decode_tb'

instruction_decode_tb.vhdl:113:7:@0ms:(report note): i=0: testing LUI x2,0x12345          
library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity instruction_decode_tb is end entity;

architecture a of instruction_decode_tb is

  function to_string(arg : std_logic_vector) return string is
    variable result : string (1 to arg'length);
    variable v : std_logic_vector (result'range) := arg;
  begin
    for i in result'range loop
      case v(i) is
        when 'U' => result(i) := 'U';
        when 'X' => result(i) := 'X';
        when '0' => result(i) := '0';
        when '1' => result(i) := '1';
        when 'Z' => result(i) := 'Z';
        when 'W' => result(i) := 'W';
        when 'L' => result(i) := 'L';
        when 'H' => result(i) := 'H';
        when '-' => result(i) := '-';
      end case;
    end loop;
    return result;
  end;



  component instruction_decode is port (
    instruction, pc_in : in std_logic_vector(31 downto 0);
    pc, lit, jumplit : out std_logic_vector(31 downto 0);
    addr_of_rs1, addr_of_rs2, addr_of_rd : out std_logic_vector(4 downto 0);
    aluop : out std_logic_vector(4 downto 0);
    sel_pc_not_rs1, sel_lit_not_rs2, is_jalr : out std_logic;
    cpuclk : in std_logic
  ); end component;
  signal instruction, pc_in : std_logic_vector(31 downto 0);
  signal pc, lit, jumplit : std_logic_vector(31 downto 0);
  signal addr_of_rs1, addr_of_rs2, addr_of_rd : std_logic_vector(4 downto 0);
  signal aluop : std_logic_vector(4 downto 0);
  signal sel_pc_not_rs1, sel_lit_not_rs2, is_jalr : std_logic;
  signal cpuclk : std_logic;

  --signal ir : std_logic_vector(31 downto 0);

begin
  my_decode : instruction_decode port map(instruction, pc_in,
					  pc, lit, jumplit,
					  addr_of_rs1, addr_of_rs2, addr_of_rd,
					  aluop,
					  sel_pc_not_rs1, sel_lit_not_rs2, is_jalr,
					  cpuclk);

  process
    type sim_line is record
      irh,irl, jlit,lith,litl, ars1,ars2,ard, selpcz,sellit, alu:integer;
      nam:string(1 to 24);
    end record;
    type sim_array is array (natural range <>) of sim_line;
    constant simdata : sim_array := (
    --                     literal            ars1,2,d selpcz/lit aluop
      (16#1234#,16#5137#, 0,16#1234#,16#5000#,  0,-1,2,     0,1,     0, "LUI x2,0x12345          "),
      (16#fedc#,16#b217#, 0,16#fedc#,16#b000#, -1,-1,4,     1,1,     0, "AUIPC x4,0xfedcb        "),
    -- 2 folgt
      (16#0020#,16#0fef#, 1,16#0000#,16#0002#, -1,-1,31,    1,2,    19, "JAL x31,0x2             "),
      (16#0040#,16#0eef#, 1,16#0000#,16#0004#, -1,-1,29,    1,2,    19, "JAL x29,0x4             "),
      (16#0080#,16#0def#, 1,16#0000#,16#0008#, -1,-1,27,    1,2,    19, "JAL x27,0x8             "),
      (16#0100#,16#0cef#, 1,16#0000#,16#0010#, -1,-1,25,    1,2,    19, "JAL x25,0x10            "),
      (16#0200#,16#0bef#, 1,16#0000#,16#0020#, -1,-1,23,    1,2,    19, "JAL x23,0x20            "),
      (16#0400#,16#0aef#, 1,16#0000#,16#0040#, -1,-1,21,    1,2,    19, "JAL x21,0x40            "),
      (16#0800#,16#09ef#, 1,16#0000#,16#0080#, -1,-1,19,    1,2,    19, "JAL x19,0x80            "),
      (16#1000#,16#08ef#, 1,16#0000#,16#0100#, -1,-1,17,    1,2,    19, "JAL x17,0x100           "),
      (16#2000#,16#07ef#, 1,16#0000#,16#0200#, -1,-1,15,    1,2,    19, "JAL x15,0x200           "),
      (16#4000#,16#06ef#, 1,16#0000#,16#0400#, -1,-1,13,    1,2,    19, "JAL x13,0x400           "),
      (16#0010#,16#05ef#, 1,16#0000#,16#0800#, -1,-1,11,    1,2,    19, "JAL x11,0x800           "),
      (16#0000#,16#14ef#, 1,16#0000#,16#1000#, -1,-1,9,     1,2,    19, "JAL x9,0x1000           "),
      (16#0000#,16#23ef#, 1,16#0000#,16#2000#, -1,-1,7,     1,2,    19, "JAL x7,0x2000           "),
      (16#0000#,16#42ef#, 1,16#0000#,16#4000#, -1,-1,5,     1,2,    19, "JAL x5,0x4000           "),
      (16#0000#,16#81ef#, 1,16#0000#,16#8000#, -1,-1,3,     1,2,    19, "JAL x3,0x8000           "),
      (16#0001#,16#00ef#, 1,16#0001#,16#0000#, -1,-1,1,     1,2,    19, "JAL x1,0x10000          "),
      (16#0002#,16#00ef#, 1,16#0002#,16#0000#, -1,-1,1,     1,2,    19, "JAL x1,0x20000          "),
      (16#0004#,16#00ef#, 1,16#0004#,16#0000#, -1,-1,1,     1,2,    19, "JAL x1,0x40000          "),
      (16#0008#,16#00ef#, 1,16#0008#,16#0000#, -1,-1,1,     1,2,    19, "JAL x1,0x80000          "),
      (16#8000#,16#00ef#, 1,16#fff0#,16#0000#, -1,-1,1,     1,2,    19, "JAL x1,0x100000         "),
    -- 22 folgt
      (16#8008#,16#0367#, 1,16#ffff#,16#f800#, 16,-1,6,     1,2,    19, "JALR x6,0xfffff800(x16) "),
      (16#00a4#,16#0163#, 1,16#0000#,16#0002#, 8,10,0,      0,0,    16, "beq x8,x10,+2           "),
      (16#00a4#,16#1263#, 1,16#0000#,16#0004#, 8,10,0,      0,0,    17, "bne x8,x10,+4           "),
      (16#00a4#,16#4463#, 1,16#0000#,16#0008#, 8,10,0,      0,0,    20, "blt x8,x10,+8           "),
      (16#00a4#,16#5863#, 1,16#0000#,16#0010#, 8,10,0,      0,0,    21, "bge x8,x10,+16          "),
      (16#02a4#,16#6063#, 1,16#0000#,16#0020#, 8,10,0,      0,0,    22, "bltu x8,x10,+32         "),
      (16#04a4#,16#7063#, 1,16#0000#,16#0040#, 8,10,0,      0,0,    23, "bgeu x8,x10,+64         "),
      (16#0830#,16#8063#, 1,16#0000#,16#0080#,  1,3,0,      0,0,    16, "beq x1,x3,+128          "),
      (16#10a4#,16#0063#, 1,16#0000#,16#0100#, 8,10,0,      0,0,    16, "beq x8,x10,+256         "),
      (16#20a4#,16#0063#, 1,16#0000#,16#0200#, 8,10,0,      0,0,    16, "beq x8,x10,+512         "),
      (16#40a4#,16#0063#, 1,16#0000#,16#0400#, 8,10,0,      0,0,    16, "beq x8,x10,+1024        "),
      (16#00a4#,16#00e3#, 1,16#0000#,16#0800#, 8,10,0,      0,0,    16, "beq x8,x10,+2048        "),
      (16#80a4#,16#0063#, 1,16#ffff#,16#f000#, 8,10,0,      0,0,    16, "beq x8,x10,-4096        "),
    -- 35 folgt
      --(16#001f#,16#d783#, 0,16#0000#,16#0001#, 31,-1,15,    0,1,     0, "lhu x15,1(x31)          "),
      --(16#feef#,16#2e23#, 0,16#ffff#,16#fffc#, 30,14,0,     0,1,     0, "sw  x14,-4(x30)         "),
      (16#4054#,16#5813#, 3,16#0000#,16#0005#, 8,-1,16,     0,1,    13, "srai x16,x8,5           "),
      (16#4044#,16#0c33#, 2,      -1,-1,       8,4,24,      0,0,     8, "sub x24,x8,x4           "),
    (0,0,0,0,0,0,0,0,0,0,0,"                        "));
    -- (others => 0));

    variable tmp : integer;

  begin
    for i in simdata'left to simdata'right-1 loop
      report "i=" & integer'image(i) & ": testing " & simdata(i).nam;
      instruction(31 downto 16) <= std_logic_vector(to_unsigned(simdata(i).irh, 16));
      instruction(15 downto  0) <= std_logic_vector(to_unsigned(simdata(i).irl, 16));
      cpuclk <= '0'; wait for 1 fs;
      cpuclk <= '1'; wait for 1 fs;
      cpuclk <= '0'; wait for 1 fs;

      --report integer'image(i) & ": " & to_string(instruction); wait for 1 fs;
      if simdata(i).jlit = 0 then -- check lit is as expected
	if simdata(i).lith /= to_integer(unsigned(lit(31 downto 16))) then
	    report "IR: " & to_string(instruction);
	    report "lit is wrong" severity failure;
	end if;
	if simdata(i).litl /= to_integer(unsigned(lit(15 downto 0))) then
	    report "IR: " & to_string(instruction);
	    report "lit is wrong" severity failure;
	end if;
      elsif simdata(i).jlit = 1 then -- check jumplit is as expected
	if simdata(i).lith /= to_integer(unsigned(jumplit(31 downto 16))) then
	    report "IR: " & to_string(instruction);
	    report "jumplit is wrong" severity failure;
	end if;
	if simdata(i).litl /= to_integer(unsigned(jumplit(15 downto 0))) then
	    report "IR: " & to_string(instruction);
	    report "jumplit is wrong" severity failure;
	end if;
      elsif simdata(i).jlit = 3 then
	if simdata(i).litl /= to_integer(unsigned(lit(4 downto 0))) then
	    report "IR: " & to_string(instruction);
	    report "shamt is wrong" severity failure;
	end if;
      end if;

      if simdata(i).ars1 /= -1 then
	if simdata(i).ars1 /= to_integer(unsigned(addr_of_rs1)) then
	  report "IR: " & to_string(instruction);
	  report "addr_of_rs1 is wrong" severity failure;
	end if;
      end if;
      if simdata(i).ars2 /= -1 then
	if simdata(i).ars2 /= to_integer(unsigned(addr_of_rs2)) then
	  report "IR: " & to_string(instruction);
	  report "addr_of_rs2 is wrong" severity failure;
	end if;
      end if;
      if simdata(i).ard /= -1 then
	if simdata(i).ard /= to_integer(unsigned(addr_of_rd)) then
	  report "IR: " & to_string(instruction);
          if instruction(6 downto 0)="1100011" then
	    report "addr_of_rd must be 00000 for branches" severity failure;
          end if;
	  report "addr_of_rd is wrong" severity failure;
	end if;
      end if;

      if simdata(i).selpcz = 1 then
	if sel_pc_not_rs1='0' then --or alu_op1_zero='1' then
	  report "IR: " & to_string(instruction);
	  report "alu op1 selected wrongly" severity failure;
	end if;
      else
	if sel_pc_not_rs1='1' then --or alu_op1_zero='1' then
	  report "IR: " & to_string(instruction);
	  report "alu op1 selected wrongly" severity failure;
	end if;
      end if;

      if simdata(i).sellit = 2 then
        -- do not care - do not test
      elsif simdata(i).sellit = 1 then
	if sel_lit_not_rs2='0'  then --or  alu_op2_zero='1' then
	  report "IR: " & to_string(instruction);
	  report "alu op2 selected wrongly" severity failure;
	end if;
      elsif simdata(i).sellit = 0 then
	if sel_lit_not_rs2='1'  then --or  alu_op2_zero='1' then
	  report "IR: " & to_string(instruction);
	  report "alu op2 selected wrongly" severity failure;
	end if;
      end if;

      if aluop(4)='1' then
        -- aluop(3) is do not care !
        tmp := 16 + to_integer(unsigned(aluop(2 downto 0)));
      else
        tmp := to_integer(unsigned(aluop(3 downto 0)));
      end if;
      if simdata(i).alu /= tmp then
        report "IR: " & to_string(instruction);
        report "aluop is wrong" severity failure;
      end if;

      if instruction(6 downto 0) = "1100111" then
        if is_jalr='0' then
          report "IR: " & to_string(instruction);
          report "is_jalr is wrong" severity failure;
        end if;
      else
        if is_jalr='1' then
          report "IR: " & to_string(instruction);
          report "is_jalr is wrong" severity failure;
        end if;
      end if;

      wait for 1 fs;
    end loop;
    report "end of instruction_decode_tb -- reaching here is: test OK";
    wait;
  end process;
end architecture;






../../src/ieee/v93/numeric_std-body.vhdl:2098:7:@3fs:(assertion warning): NUMERIC_STD.TO_INTEGER: metavalue detected, returning 0
instruction_decode_tb.vhdl:123:12:@3fs:(report note): IR: 00010010001101000101000100110111
instruction_decode_tb.vhdl:124:12:@3fs:(report failure): lit is wrong
/usr/bin/ghdl-mcode:error: report failed
in process .instruction_decode_tb(a).P0
  from: process work.instruction_decode_tb(a).P0 at instruction_decode_tb.vhdl:126
/usr/bin/ghdl-mcode:error: simulation failed

