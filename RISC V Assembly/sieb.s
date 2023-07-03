main:                                   
        addi    sp, sp, -1040
        sw      ra, 1036(sp)                    
        sw      s0, 1032(sp)                    
        addi    s0, sp, 1040
        li      t0, 2
        li      t1, 1000

innit_array:                             
        blt     t1, t0, start
        addi    t1, s0, -1036
        add     t1, t1, t0
        li      a0, 0
        sb      a0, 0(t1)
        li      t1, 1000
        addi    t0, t0, 1
        j       innit_array
        
        
start:
        li      t3, 2
        li      t4, 1000

Outer_Loop:                               
        li      t4, 1000
        blt     t4, t3, exit
        addi    t4, s0, -1036
        add     t4, t4, t3
        lbu     a0, 0(t4)
        andi    a0, a0, 1
        bnez    a0, second_loop
        j       print_prime
        
print_prime:                               
        li a0, 10
        li a7, 11
        ecall
        mv a0, t3
        li a7,1
        ecall
        
second_loop:
        mul     t5, t3, t3
        li      t6, 1000
        
not_prime_loop:                                
        li      t6, 1000
        blt     t6, t5, exit_inner_loop
        addi    t6, s0, -1036
        add     t6, t6, t5
        li      a0, 1
        sb      a0, 0(t6)
        add     t5, t5, t3
        j       not_prime_loop

exit_inner_loop:                               
        addi    t3, t3, 1
        j       Outer_Loop
        
exit:
        lw      a0, -24(s0)
        mv      sp, a0
        lw      a0, -16(s0)
        lw      ra, 1036(sp)                    
        lw      s0, 1032(sp)                    
        addi    sp, sp, 1040
        li a7, 10
        ecall