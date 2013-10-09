# Fancy Foods
The sample application presented in the Enterprise OSGi in Action book.

[![Build Status](https://buildhive.cloudbees.com/job/danielpacak/job/fancy-foods/badge/icon)](https://buildhive.cloudbees.com/job/danielpacak/job/fancy-foods/)

## Download
Fancy Foods is distributed in several formats for your convenience. Use a source code archive if you intend to [build](#build)
Fancy Foods yourself. Otherwise, simply pick a ready-made binary distribution and follow the installation instruction
given below.

### Fancy Foods 1.0.0
This is the current stable version of Fancy Foods.

|                                   | Link                                      | Checksum | Signature |
| --------------------------------- | ----------------------------------------- |:--------:|:---------:|
| Fancy Foods 1.0.0 (Binary tar.gz) | fancyfoods.distribution-1.0.0-full.tar.gz | xxx      | xxx       |
| Fancy Foods 1.0.0 (Binary zip)    | fancyfoods.distribution-1.0.0-full.zip    | xxx      | xxx       |
| Release Notes                     | 1.0.0                                     |          |           |
| Release Reference Documentation   | 1.0.0                                     |          |           |

## Installation
Fancy Foods is a Java application, so you must have [Java](http://www.oracle.com/technetwork/java) installed in order to proceed. Additional optional
installation steps are listed after the platform specific instructions.

### Windows
1. Unzip the distribution archive, i.e. *fancyfoods.distribution-0.0.1-SNAPSHOT-full.zip* to the directory you wish to install Fancy Foods.
   These instructions assume you chose *C:\Program Files*. The subdirectory *fancyfoods.distribution-0.0.1-SNAPSHOT-full* will be created from
   the archive.
2. Open a new command prompt (*Winkey* + *R* then type *cmd*) and change directory to *C:\Program Files\fancyfoods.distribution-0.0.1-SNAPSHOT-full\bin*.
3. Run *fancyfoods.bat* to start the application.
4. Open the following URL in your browser *http://localhost:8080/fancyfoods.web/SayHelloJNDI* to verify that it is correctly
   installed.

### Unix-based Operating Systems (Linux, Solaris and Mac OS X)
1. Extract the distribution archive, i.e. *fancyfoods.distribution-0.0.1-SNAPSHOT-full.tar.gz* to the directory you wish to install Fancy Foods.
   These instructions assume you chose */usr/local*. The subdirectory *fancyfoods.distribution-0.0.1-SNAPSHOT-full* will be created from the
   archive.
2. Change directory to */usr/local/fancyfoods.distribution-0.0.1-SNAPSHOT-full/bin*.
3. Run *fancyfoods.sh* to start the application.
4. Open the following URL in your browser *http://localhost:8080/fancyfoods.web/SayHelloJNDI* to verify that it is correctly
   installed.

## Optional Configuration
Fancy Foods will start and work with the default configuration, however there are situations when you will need to configure
settings. The following sections refer to what is available.

### Settings
Fancy Foods has a *config/fancyfoods.properties* settings file located in the installation directory that configure
environmental specifics such as:

* HTTP server
* JDBC data sources
* other configuration properties

## Build
A quick guide for getting the Fancy Foods source, then building the resulting Fancy Foods instance; either without
or with [Eclipse](http://www.eclipse.org).

> Before you begin, you need to have the following tools installed on your system:
>
> * Java Development Kit 6 or higher; JDK 6 is recommended.
> * Maven 3.0.4 or later; enforced by the Fancy Foods parent pom.
> * A Git client.

1. Clone the source from GitHub repository *git clone https://github.com/danielpacak/fancy-foods.git* to the working directory.
   These instructions assume you chose *C:\development\github\fancy-foods*.
2. Change directory to *C:\development\github\fancy-foods* and build the project *mvn install*.
3. Launch Fancy Foods...
  * (with Maven) ...by running the *felix.bat* script in the *C:\development\github\fancy-foods\runner.pax* directory.
  * (or) ...by running the *fancyfoods.bat* script in the
   *C:\development\github\fancy-foods\distribution\target\fancyfoods.distribution-0.0.1-SNAPSHOT-full/bin* directory.
5. Open the following URL in your browser *http://localhost:8080/fancyfoods.web/SayHelloJNDI*.

> The [felix.bat](https://raw.github.com/danielpacak/fancy-foods/master/runner.pax/felix.bat)
> script starts up the OSGi runtime (Apache Felix by default) and installs all dependencies listed in
> [pom.xml](https://raw.github.com/danielpacak/fancy-foods/master/runner.pax/pom.xml) as OSGi bundles.

> To change the default OSGi runtime (from [Apache Felix](http://felix.apache.org/) to
> [Eclipse Equinox](http://www.eclipse.org/equinox)) edit [felix.bat](https://raw.github.com/danielpacak/fancy-foods/master/runner.pax/felix.sh)
> and set the `FRAMEWORK` environment variable to `equinox`.
