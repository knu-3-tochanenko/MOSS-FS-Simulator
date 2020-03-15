## How to use simulator

Run `javac *.java` whenever you change source code.

We use Visual Studio Code to edit code, so I will give you instructions on how to use MOSS FS in VS Code.

There is `commands.bat` for fast commands executing from CMD. You just need to open terminal and select `cmd` as your default Shell. If you don't see `cmd` shell, select `Select Default Shell -> cmd` and then press on plus `+` sign near shell dropdown. It should open needed shell.

To run commands just type `commands` or `commands.bat`. Feel free to change this file to your likings.

## Task list
* [ ] DONE ALL
* [ ] [Task 1 : Vlad / Taya](#task-1)
* [ ] [Task 2 : Vlad / Taya](#task-2)
* [ ] [Task 3 : Vlad / Taya](#task-3)
* [ ] [Task 4 : Vlad / Taya](#task-4)
* [ ] [Task 5 : Vlad / Taya](#task-5)
* [ ] [Task 6 : Vlad / Taya](#task-6)
* [ ] [Task 7 : Vlad / Taya](#task-7)

### Task 1
Use `mkfs` to create a file system with a block size of 64 bytes and having a total of 8 blocks. How many index nodes will fit in a block? How many directory entries will fit in a block? Use dump to examine the file system backing file, and note the value in byte 64. What does this value represent? Use `mkdir` to create a directory (e.g., `/usr`), and then use dump to examine byte 64 again. What do you notice? Repeat the process of creating a directory (e.g., `/bin`, `/lib`, `/var`, `/etc`, `/home`, `/mnt`, etc.) and examining with dump. How many directories can you create before you fill up the file system? Explain why.

### Task 2
Enhance `ls.java` to display for each file the uid and gid as decimal numbers, and the 9 low-order bits of mode as a 3-digit octal number (i.e., 000..777).

### Task 3
Write a program `find.java` which, given a path name, checks to see if the path exists, and if so lists that path name and all files in all directories (and sub-directories, and sub-sub-directories, etc.) under it, one path name per line. For example:

```
java find /home
```

might produce the following output:

```
/home
/home/nathant
/home/nathant/bar.txt
/home/nathant/foo.txt
/home/rayo
/home/rayo/homer
/home/rayo/homer/odyssey.txt
/home/rayo/homer/iliad.txt
/home/rayo/virgil
/home/rayo/virgil/aeneid.txt
/home/rayo/virgil/eclogues.txt
/home/rayo/virgil/georgics.txt
```

under the right circumstances, of course. Hint: Your program may include a recursive method or an array for keeping track of each directory as you open it. What is the maximum directory tree depth to which your program will work?

### Task 4
Enhance the file system simulator to include a new method, `Kernel.chown()`, which, given the name of a file, a uid, and a gid, sets the file's uid and gid to the values given. Note that only the owner of a file (or the super-user) may change the gid of a file. Only the super-user may change the uid of a file. To test your new method, write two new programs `chown.java` and `chgrp.java` which accept a uid or gid (respectively) and a list of file or directory names.

### Task 5
Enhance the file system simulator to include a new method, Kernel.chmod(), which, given the name of a file and a mode, sets the file's mode to the value given. Note that only the owner of a file (or the super-user) may change the mode for a file, and that only the 9 low-order bits of mode are affected. To test your new method, write a new program chmod.java which accepts a mode value (000..777) and a list of file or directory names.

### Task 6
Enhance the file system simulator to include a new method, `Kernel.umask()`, which, given a umask, saves that umask in the process context and returns the *previous* umask value. Note that only the 9 low-order bits of the umask are used. Further, modify `Kernel.creat()` so that the mode for newly created files is the logical and of the given mode and the *compliment* of the current umask value from the process context.

### Task 7
Enhance the file system simulator to include a new method, `Kernel.link()`, which, given two path names, creates the second path as a (hard) link to the first path. `link()` should find the inode number for the first file, and then write a directory entry for the second path which references the same index node. Don't forget to increment nlink on the index node. To test your new method, write a new program, `ln.java`, which, given two path names, performs the `link()` operation. Assume that creating a link to a directory is not allowed.