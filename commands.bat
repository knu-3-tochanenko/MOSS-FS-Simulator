call java mkfs filesys.dat 256 16
call java mkdir /root
call java ls /
call dir /b *.java | java tee /root/t.lis
call java ls /root
call java cat /root/t.lis