TARGET := OdtExample.class
ODT_API_LIBRARY := quick_odt/lib/odfdom.jar
# NOTE: There's some rules for using the classpath:
# - To use more than one path, concatenate two paths with a colon.
#   Example: ".:.." to use the current and parent directory in the
#   classpath.
# - To use a .class file, just put the path to the containing
#   directory of the .class file in the classpath.
# - To use a .jar file, put the path to the .jar file, or the path to
#   the containing directory followed by "/*" as a wildcard which will
#   use all the .jar files in the directory.
# Source: # <https://docs.oracle.com/javase/7/docs/technotes/tools/windows/classpath.html>
ODFLIBS := $(abspath ./lib)/*

all : $(TARGET)

%.class : %.java
	javac -classpath "$(ODFLIBS)" $<

# NOTE: In order to .class file, the file has to be in the classpath.
# The argument at the end of the java command is an entry-point class
# name, it won't automatically find the corresponding class file where
# it lives without having the location of the .class file in the
# classpath.
%.run : %.class
	cd $(dir $@); java -classpath ".:$(ODFLIBS)" $(basename $(notdir $@))
%.jar : %.class
	jar cf $< $@ -classpath ".:$(ODFLIBS)" $<
