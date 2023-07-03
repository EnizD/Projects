.data
input:  .string "the quick brown fox jumps over the lazy dog"   # Input string

.text
main:
  li t0, 97             #ASCII-Value of a
  li t1, 122            #ASCII-Value of z
  addi sp,sp,-16
  sw ra,0(sp)
  sw s0,4(sp)
  
  la s0, input

loop:
     lb t2, 0(s0)
     beqz t2, exit
     addi t2, t2, 13
     
     bgt t2, t1, wrap
     blt t2, t0, wrap
     
print:
        
     mv a0, t2
     li a7, 11
     ecall
     addi s0, s0, 1
     j loop
     
wrap:
    lb t2, 0(s0)
    addi t2, t2, -13
    j print 
    
exit:
    lw ra, 0(sp)
    lw s0, 4(sp)
    addi sp,sp, 16
    li a7, 10
    ecall
    

    