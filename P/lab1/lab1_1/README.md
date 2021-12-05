### Java

Check version of java present on the machine:

```bash
[pengrey@pengrey-sy lab1_1]$ javac -version
javac 17
[pengrey@pengrey-sy lab1_1]$
```

Download java on Arch with pacman:

```bash
sudo pacman -S jre-openjdk  # Java Runtime Environment (most recent)
sudo pacman -S jdk-openjdk  # Java Development Kit (most recent)
```

### Git

Check version of git present on the machine:

```bash
[pengrey@pengrey-sy lab1_1]$ git --version
git version 2.33.0
[pengrey@pengrey-sy lab1_1]$
```

List configurations set on the machine:

```bash
git config --list
```

Example of output:

```bash
user.email=rodrigoflima.me@gmail.com
user.name=Pengrey
core.repositoryformatversion=0
core.filemode=true
core.bare=false
core.logallrefupdates=true
remote.origin.url=git@github.com:Pengrey/IES_98475.git
remote.origin.fetch=+refs/heads/*:refs/remotes/origin/*
branch.master.remote=origin
branch.master.merge=refs/heads/master
```