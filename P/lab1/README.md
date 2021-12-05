# Review questions

### A) Maven has three lifecycles: clean, site and default. Explain the main phases in the default lifecycle.

Maven has three lifecycles, clean that that handles project cleaning (deletes temporary files made for build up), the default phase that handles the deployments of the project and the site lifestyle that handles the creation of the project's web page.

### B) Maven is a build tool; is it appropriate to run your project to?

Maven is a program that is used to build and manage projects, using it helps on the build process to be more consistent and helps applying good practices.

### C) What would be a likely sequence of Git commands required to contribute with a new feature to a given project? (i.e., get a fresh copy, develop some increment, post back the added functionality)

The sequence of commands required to contribute with a new feature to a given project are:

Create a branch to work on:

```bash
git checkout -b <feature branch name>
```

Create .gitignore for files we dont want to push on the project

```bash
vim .gitignore
```

Create the new feature on the code and add it to the staging area:

```bash
git add --all
```

Create a commit to help backtracking if needed and to help labeling:

```bash
git commit -m "meaningful commit message"
```

Change to the master branch

```bash
git checkout master
```

Merge the current branch (master) with the new feature branch:

```bash
git merge <feature branch name>
```

### D) There are strong opinions on how to write Git commit messages… Find some best practices online and give your own informed recommendations on how to write good commit messages (in a team project).

In a team project we should aim for a short, single lined and precise commit, favorably on the present tense, commits shouldnt be confusing because the need to be as much informative as we need for a time of crysis or rollback.

### E) Docker automatically prepares the required volume space as you start a container. Why is it important that you take an extra step configuring the volumes for a (production) database?

In a production database we cant have the data being lost if we stop the container and start it again, for this we will neeed persitence, we can do this by giving the command run the -v flag and the path to where we want to save the data to in our machine, with this each time we're using the docker run command, the data will be persisted along with the different container executions.