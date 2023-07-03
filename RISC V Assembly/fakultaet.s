fakultaet:
    addi a0, zero, 1
    addi t1, zero, 1
    addi t2, zero, 5
loop:
    bgt t1, t2, end_loop
    mul a0, a0, t1
    addi t1, t1, 1
    j loop

end_loop:
    li a7, 1
    ecall
    li a7, 10
    ecall


