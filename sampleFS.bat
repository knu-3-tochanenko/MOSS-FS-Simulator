call java mkfs filesys.dat 256 40
call java mkdir /bin
call java mkdir /lib
call java mkdir /etc
call java mkdir /home
call java mkdir /home/nathant
call echo "bar" | java tee /home/nathant/bar.txt
bar
call echo "foo" | java tee /home/nathant/foo.txt
call java mkdir /home/rayo
call java mkdir /home/rayo/homer
call echo "odyssey" | java tee /home/rayo/homer/odyssey.txt
call echo "iliad" | java tee /home/rayo/homer/iliad.txt
call java mkdir /home/rayo/virgil
call echo "aeneid" | java tee /home/rayo/virgil/aeneid.txt
call echo "eclogues" | java tee /home/rayo/virgil/eclogues.txt
call echo "georgics" | java tee /home/rayo/virgil/georgics.txt