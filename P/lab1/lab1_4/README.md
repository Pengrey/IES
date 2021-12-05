# Docker

> Docker Desktop is an easy-to-install application for your Mac or Windows environment that enables you to build and share containerized applications and microservices. Docker Desktop includes Docker Engine, Docker CLI client, Docker Compose, Docker Content Trust, Kubernetes, and Credential Helper.
> 

Installation:

```bash
sudo pacman -S docker
```

### Manage Docker as a non-root user:

The Docker daemon binds to a Unix socket instead of a TCP port. By default that Unix socket is owned by the user root and other users can only access it using sudo. The Docker daemon always runs as the root user.

If we don’t want to preface the docker command with sudo, we can create a Unix group called docker and add users to it. When the Docker daemon starts, it creates a Unix socket accessible by members of the docker group.

To create the `docker` group and add your user:

1. Create the `docker` group.

```bash
sudo groupadd docker
```

1. Add your user to the `docker` group.

```bash
sudo usermod -aG docker $USER
```

1. Log out and log back in so that your group membership is re-evaluated.
    
    If testing on a virtual machine, it may be necessary to restart the virtual machine for changes to take effect.
    
    On a desktop Linux environment such as X Windows, log out of your session completely and then log back in.
    
    On Linux, you can also run the following command to activate the changes to groups:
    

```bash
newgrp docker
```

1. Verify that you can run `docker` commands without `sudo`.

```bash
 docker run hello-world
```

## Configure Docker to start on boot

Most current Linux distributions (RHEL, CentOS, Fedora, Debian, Ubuntu 16.04 and higher) use `[systemd](https://docs.docker.com/config/daemon/systemd/)` to manage which services start when the system boots. On Debian and Ubuntu, the Docker service is configured to start on boot by default. To automatically start Docker and Containerd on boot for other distros, use the commands below:

```bash
sudo systemctl enable docker.service
sudo systemctl enable containerd.service
```

To disable this behavior, use `disable` instead.

```bash
sudo systemctl disable docker.service
sudo systemctl disable containerd.service
```

### Run Container

```bash
docker run <container name>
```

### List running Containers

```bash
docker ps
```

Options:

- `a` - The -a, --all option tells docker container ls to print a list of all containers

### List Containers

```bash
docker container ls
```

Options:

- `a` - The -a, --all option tells docker container ls to print a list of all containers
- `q` - To only display the containers' IDs pass the -q, --quiet option

### Kill Containers

The following example sends the default SIGKILL signal to the container named my_container:

```bash
docker kill my_container
```

### Remove container:

```bash
docker container rm
```

### Get Container IP address

```bash
docker inspect -f \
'{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' \
<container id>
```

### Docker tutorial

Part 1:

To run the docker tutorial container we need to run the following command:

```bash
 docker run -d -p 80:80 docker/getting-started
```

We’ll notice a few flags being used. Here’s some more info on them:

- `d` - run the container in detached mode (in the background)
- `p 80:80` - map port 80 of the host to port 80 in the container
- `docker/getting-started` - the image to use

> Tip: We can combine single character flags to shorten the full command. As an example, the command above could be written as:
> 
> 
> ```bash
> docker run -dp 80:80 docker/getting-started
> ```
> 

Part 2:

### Build the app’s container image

In order to build the application, we need to use a `Dockerfile`. A Dockerfile is simply a text-based script of instructions that is used to create a container image. If we’ve created Dockerfiles before, we might see a few flaws in the Dockerfile below. We’ll go over them.

1. Create a file named `Dockerfile` in the same folder as the file `package.json` with the following contents.
    
    ```bash
    # syntax=docker/dockerfile:1
    FROM node:12-alpine
    RUN apk add --no-cache python g++ make
    WORKDIR /app
    COPY . .
    RUN yarn install --production
    CMD ["node", "src/index.js"]
    ```
    
    Please check that the file `Dockerfile` has no file extension like `.txt`. Some editors may append this file extension automatically and this would result in an error in the next step.
    
2. If you haven’t already done so, open a terminal and go to the `app` directory with the `Dockerfile`. Now build the container image using the `docker build` command.

```bash
docker build -t getting-started .
```

This command used the Dockerfile to build a new container image. You might have noticed that a lot of “layers” were downloaded. This is because we instructed the builder that we wanted to start from the `node:12-alpine` image. But, since we didn’t have that on our machine, that image needed to be downloaded.

After the image was downloaded, we copied in our application and used `yarn` to install our application’s dependencies. The `CMD` directive specifies the default command to run when starting a container from this image.

Finally, the `-t` flag tags our image. Think of this simply as a human-readable name for the final image. Since we named the image `getting-started`, we can refer to that image when we run a container.

The `.` at the end of the `docker build` command tells that Docker should look for the `Dockerfile` in the current directory.

### Portainer

Portainer hides the complexity of managing containers behind an easy-to-use UI. By removing the need to use the CLI, write YAML or understand manifests, Portainer makes deploying apps and troubleshooting problems so easy that anyone can do it.

Install

First, create the volume that Portainer Server will use to store its database:

```bash
docker volume create portainer_data
```

Then, download and install the Portainer Server container:

```bash
docker run -d -p 8000:8000 -p 9443:9443 --name portainer \
--restart=always \
-v /var/run/docker.sock:/var/run/docker.sock \
-v portainer_data:/data \
portainer/portainer-ce:latest
```

Default page:

```bash
https://localhost:9443
```

### PostgreSQL

Create and run container:

```bash
docker run --name pg-docker -e POSTGRES_PASSWORD=docker -e POSTGRES_DB=sampledb -e PGDATA=/tmp -d -p 5432:5432 -v ${PWD}:/var/lib/postgresql/data postgres:11
```

Install PG-admin using Docker:

Download the pgAdmin-4 browser version from docker-hub using the following command.

```bash
docker run --rm -p 5050:5050 thajeztah/pgadmin4
```

We can the access it by going to the followinmg webpage: [http://localhost:5050](http://localhost:5050/)

Connecting to the PSQL server via CLI:

1. Find the docker-container-id in which the postgres is running using the below command.
    
    ```bash
    docker ps -a
    ```
    
2. Run the below command to enter into the container (with the ID from step-1).
    
    ```bash
    docker exec -it <PSQL-Container-ID> bash
    ```
    
3. Authenticate to start using as postgres user.
    
    ```bash
    psql -h localhost -p 5432 -U postgres -W
    ```
    
4. Enter the password used while creating the PSQL server container.

Example:

```bash
pengrey@pengrey-sy > docker ps                                                                                                                                                     
CONTAINER ID   IMAGE                           COMMAND                  CREATED              STATUS              PORTS                                                                                            NAMES
c0dc28e857b6   thajeztah/pgadmin4              "python ./usr/local/…"   About a minute ago   Up About a minute   0.0.0.0:5050->5050/tcp, :::5050->5050/tcp                                                        blissful_ellis
7f347e4bf466   postgres:11                     "docker-entrypoint.s…"   4 minutes ago        Up 4 minutes        0.0.0.0:5432->5432/tcp, :::5432->5432/tcp                                                        pg-docker
1e7d88c583b1   portainer/portainer-ce:latest   "/portainer"             2 hours ago          Up 2 hours          0.0.0.0:8000->8000/tcp, :::8000->8000/tcp, 0.0.0.0:9443->9443/tcp, :::9443->9443/tcp, 9000/tcp   portainer
pengrey@pengrey-sy > docker exec -it 7f347e4bf466 bash                      
root@7f347e4bf466:/# psql -h localhost -p 5432 -U postgres -W
Password: 
psql (11.13 (Debian 11.13-1.pgdg90+1))
Type "help" for help.

postgres=#
```

### Docker Compose

Compose is a tool for defining and running multi-container Docker applications. With Compose, you use a YAML file to configure your application’s services. Then, with a single command, you create and start all the services from your configuration. Compose works in all environments: production, staging, development, testing, as well as CI workflows.

Using Compose is basically a three-step process:

1. Define your app’s environment with a `Dockerfile` so it can be reproduced anywhere.
2. Define the services that make up your app in `docker-compose.ym` so they can be run together in an isolated environment.
3. Run `docker compose up` and the [Docker compose command](https://docs.docker.com/compose/cli-command/) starts and runs your entire app. You can alternatively run `docker-compose up` using the docker-compose binary.

A `docker-compose.yml` looks like this:

```bash
version: "3.9"  # optional since v1.27.0
services:
  web:
    build: .
    ports:
      - "5000:5000"
    volumes:
      - .:/code
      - logvolume01:/var/log
    links:
      - redis
  redis:
    image: redis
volumes:
  logvolume01: {}
```

Multiple isolated environments on a single host

Compose uses a project name to isolate environments from each other. 
You can make use of this project name in several different contexts:

- on a dev host, to create multiple copies of a single environment, such as when you want to run a stable copy for each feature branch of a project
- on a CI server, to keep builds from interfering with each other, you can set the project name to a unique build number
- on a shared host or dev host, to prevent different projects, which may use the same service names, from interfering with each other

The default project name is the basename of the project directory. You can set a custom project name by using the `-p` or the`COMPOSE_PROJECT_NAME` environment variable.

The default project directory is the base directory of the Compose file. A custom value for it can be defined with the `--project-directory` command line option.

Preserve volume data when containers are created

Compose preserves all volumes used by your services. When `docker-compose up`runs, if it finds any containers from previous runs, it copies the volumes from the old container to the new container. This process ensures that any data
you’ve created in volumes isn’t lost.

If you use `docker-compose` on a Windows machine, see [Environment variables](https://docs.docker.com/compose/reference/envvars/) and adjust the necessary environment variables for your specific needs.
