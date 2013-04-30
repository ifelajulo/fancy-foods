fancy-foods
===========

The sample application presented in the Enterprise OSGi in Action book.

[![Build Status](https://buildhive.cloudbees.com/job/danielpacak/job/fancy-foods/badge/icon)](https://buildhive.cloudbees.com/job/danielpacak/job/fancy-foods/)

To get the application up and running on your local machine, follow these steps:

1. Make sure you have JDK 6 installed.
2. Make sure you have Maven 3 installed.
3. Clone repository `git clone https://github.com/danielpacak/fancy-foods.git`.
4. Build the project `mvn install`.
5. Launch Apache Felix OSGi framework by running the `felix.sh` script in the `runner-pax` directory.
6. Open the following URL in your browser http://localhost:8080/fancyfoods.web/SayHelloJNDI.
7. If everything went well, you should see the application in your browser.

Note that I'm using a different approach for running the sample application than presented in the book.
If you take a look at  [this](https://github.com/danielpacak/fancy-foods/edit/master/runner.pax/felix.sh)
script, you'll see that it starts up the OSGi runtime (Apache Felix by default) and installs all
dependencies listed in [pom.xml](https://github.com/danielpacak/fancy-foods/edit/master/runner.pax/pom.xml)
as OSGi bundles.

To change the OSGi runtime simply edit [felix.sh](https://github.com/danielpacak/fancy-foods/edit/master/runner.pax/felix.sh)
and set the `FRAMEWORK` environment variable to `Equinox`.
