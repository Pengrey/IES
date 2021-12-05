# Git

Git is a popular version control system. It was created by Linus Torvalds in 2005, and has been maintained by Junio Hamano since then.

### What does Git do?

- Manage projects with **Repositories**
- **Clone** a project to work on a local copy
- Control and track changes with **Staging** and **Committing**
- **Branch** and **Merge** to allow for work on different parts and versions of a project
- **Pull** the latest version of the project to a local copy
- **Push** local updates to the main project

### Check git version:

```bash
pengrey@pengrey-sy > git --version
git version 2.33.0
pengrey@pengrey-sy >
```

### Check git status:

```bash
pengrey@pengrey-sy > git status
On branch master
Your branch is up to date with 'origin/master'.

Untracked files:
  (use "git add <file>..." to include in what will be committed)
	./

nothing added to commit but untracked files present (use "git add" to track)
pengrey@pengrey-sy >
```

> **Note:** Short status flags are:
> 
> - ?? - Untracked files
> - A - Files added to stage
> - M - Modified files
> - D - Deleted files

### Add files to git Staging Environment:

Add one file:

```bash
git add <FILENAME>
```

Add all files:

```bash
git add --all
```

or

```bash
git add -A
```

> Note: After adding files the files will be added to the Staging Environment, to add to the commit stage we need to firstly commit the changes
> 

### Git commit:

Adding commits keep track of our progress and changes as we work. Git considers each `commit` change point or "save point". It is a point in the project we can go back to if we find a bug, or want to make a change.

When we `commit`, we should **always** include a **message**.

We can commit changes by adding the changed files and then:

```bash
git commit -m "<Commit message>"
```

We can also commit changes directly, skipping the staging environment:

```bash
git commit -a -m "<Commit message>"
```

> **Warning:** Skipping the Staging Environment is not generally recommended.
> 
> 
> Skipping the stage step can sometimes make you include unwanted changes.
> 

### Git commit Log:

To view the history of commits for a repository, you can use the log command:

```bash
pengrey@pengrey-sy > git log
commit bd117ad3a6faf4e3bbd291542c8baa7eaeb34bc6 (HEAD -> master, origin/master, origin/HEAD)
Author: Pengrey <rodrigoflima.me@gmail.com>
Date:   Fri Oct 15 13:36:54 2021 +0100

    Added local READMEs

commit d9caa45c6f1543acac392ca0e543d610562919ad
Author: Pengrey <rodrigoflima.me@gmail.com>
Date:   Thu Oct 14 15:44:58 2021 +0100

    Added args check andexit for program

commit 29696a22a23628abe7044df3af8a82faffd4a83a
Author: Pengrey <rodrigoflima.me@gmail.com>
Date:   Thu Oct 14 15:39:33 2021 +0100

    Cleanning

commit 4dfa0de064e1e0af6db13e610f5c2c84fd2d0540
Author: Pengrey <rodrigoflima.me@gmail.com>
Date:   Tue Oct 12 20:24:31 2021 +0100

    added arguments feature

commit e48eacdf86491e48e470a8ccb3b3cf9e42b2b346
Author: Pengrey <rodrigoflima.me@gmail.com>
Date:   Tue Oct 12 20:14:11 2021 +0100

    Works (?) threads prob, lacks city option from args

commit 51d32bbab3eb110e007d182282bdee19b09b2ac7
Author: Pengrey <rodrigoflima.me@gmail.com>
Date:   Tue Oct 12 16:00:05 2021 +0100

    Done until g)

commit c60edf5b28452c9137e69069f9e7b75e0b912ed0
Author: Pengrey <rodrigoflima.me@gmail.com>
Date:   Tue Oct 12 14:28:53 2021 +0100

    Added README to lab1
(END)
```

### Working with Git Branches

In Git, a branch is a new/separate version of the main repository.

New Git Branch:

```bash
git branch <Branch Name>
```

Check current branch:

```bash
git branch
```

Change branch:

```bash
git checkout <Branch Name>
```

> Note: Using the -b option on checkout will create a new branch, and move to it, if it does not exist
> 

Merge Branches:

First, we need to change to the master branch

```bash
git checkout master
```

Now we merge the current branch (master) with the other branch:

```bash
git merge <Other Branch Name>
```

### Git Ignore

When sharing our code with others, there are often files or parts of your project, you do not want to share.

Examples

- log files
- temporary files
- hidden files
- personal files
- etc.

Git can specify which files or parts of your project should be ignored by Git using a `.gitignore` file.

Git will not track files and folders specified in `.gitignore`. 

> Note: The `.gitignore` file itself **IS** tracked by Git.
> 

Create .gitignore:

```bash
touch .gitignore
```

.gitignore content example:

```
# ignore ALL .log files
*.log

# ignore ALL files in ANY directory named temp
temp/
```

> **Note:** In this case, we use a single `.gitignore` which applies to the entire repository.
It is also possible to have additional `.gitignore` files in subdirectories. These only apply to files or folders within that directory.
> 

Rules for .gitignore:

| Pattern                             | Explanation/Matches                                                                                                                                                          | Examples                                                                                                         |
| ----------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------- |
|                                     | Blank lines are ignored                                                                                                                                                      |                                                                                                                  |
| \# text comment                     | Lines starting with # are ignored                                                                                                                                            |                                                                                                                  |
| name                                | All name files, name folders, and files and folders in any name folder                                                                                                       | /name.log<br>/name/file.txt<br>/lib/name.log                                                                     |
| name/                               | Ending with / specifies the pattern is for a folder. Matches all files and folders in any name folder                                                                        | /name/file.txt<br>/name/log/name.log<br><br>no match:<br>/name.log                                               |
| name.file                           | All files with the name.file                                                                                                                                                 | /name.file<br>/lib/name.file                                                                                     |
| /name.file                          | Starting with / specifies the pattern matches only files in the root folder                                                                                                  | /name.file<br><br>no match:<br>/lib/name.file                                                                    |
| lib/name.file                       | Patterns specifiing files in specific folders are always realative to root (even if you do not start with / )                                                                | /lib/name.file<br><br>no match:<br>name.file<br>/test/lib/name.file                                              |
| \*\*/lib/name.file                  | Starting with \*\* before / specifies that it matches any folder in the repository. Not just on root.                                                                        | /lib/name.file<br>/test/lib/name.file                                                                            |
| \*\*/name                           | All name folders, and files and folders in any name folder                                                                                                                   | /name/log.file<br>/lib/name/log.file<br>/name/lib/log.file                                                       |
| /lib/\*\*/name                      | All name folders, and files and folders in any name folder within the lib folder.                                                                                            | /lib/name/log.file<br>/lib/test/name/log.file<br>/lib/test/ver1/name/log.file<br><br>no match:<br>/name/log.file |
| \*.file                             | All files withe .file extention                                                                                                                                              | /name.file<br>/lib/name.file                                                                                     |
| \*name/                             | All folders ending with name                                                                                                                                                 | /lastname/log.file<br>/firstname/log.file                                                                        |
| name?.file                          | ? matches a single non-specific character                                                                                                                                    | /names.file<br>/name1.file<br><br>no match:<br>/names1.file                                                      |
| name\[a-z\].file                    | \[range\] matches a single character in the specified range (in this case a character in the range of a-z, and also be numberic.)                                            | /names.file<br>/nameb.file<br><br>no match:<br>/name1.file                                                       |
| name\[abc\].file                    | \[set\] matches a single character in the specified set of characters (in this case either a, b, or c)                                                                       | /namea.file<br>/nameb.file<br><br>no match:<br>/names.file                                                       |
| name\[!abc\].file                   | \[!set\] matches a single character, except the ones spesified in the set of characters (in this case a, b, or c)                                                            | /names.file<br>/namex.file<br><br>no match:<br>/namesb.file                                                      |
| \*.file                             | All files withe .file extention                                                                                                                                              | /name.file<br>/lib/name.file                                                                                     |
| name/<br>!name/secret.log           | ! specifies a negation or exception. Matches all files and folders in any name folder, except name/secret.log                                                                | /name/file.txt<br>/name/log/name.log<br><br>no match:<br>/name/secret.log                                        |
| \*.file<br>!name.file               | ! specifies a negation or exception. All files withe .file extention, except name.file                                                                                       | /log.file<br>/lastname.file<br><br>no match:<br>/name.file                                                       |
| \*.file<br>!name/\*.file<br>junk.\* | Adding new patterns after a negation will re-ignore a previous negated file<br>All files withe .file extention, except the ones in name folder. Unless the file name is junk | /log.file<br>/name/log.file<br><br>no match:<br>/name/junk.file                                                  |

Local and Personal Git Ignore Rules:

It is also possible to ignore files or folders but not show it in the distubuted `.gitignore` file.

These kinds of ignores are specified in the `.git/info/exclude` file. It works the same way as `.gitignore` but are not shown to anyone else.