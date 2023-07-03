addi ra zero done
addi a0 zero 5

fib:
    beq a0 zero done
    addi t2 zero 1
    beq a0 t2 done
    
reca:
    addi sp sp -12
    sw ra 0(sp)
    bne a0 zero return
    sw a0 4(sp)
    sw t2 8(sp)
    jr ra
    
return:
    addi a0 a0 -1
    jal reca
    lw t0 4(sp)
    lw t1 8(sp)
    addi sp sp 12
    lw ra 0(sp)
    sw t0 8(sp)
    add a0 t0 t1
    sw a0 4(sp)
    jr ra

done:
    li a7,1
    ecall
    li a7,10
    ecall
    