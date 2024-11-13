#------------------------------------------------------------------------------#
#   INGREDIENTS                                                                #
#------------------------------------------------------------------------------#

# Sources
SRC_MAIN		:= src/main/java
SRC_TEST		:= src/test/java

# Output files (.class files)
OUT_DIR			:= out
OUT_TEST_DIR	:= out/test

# Main
MAIN_CLASS		:= main.java.com.fourtytwo.avajlauncher.AvajLauncher
TEST_MAIN_CLASS	:= MainTestSuite

SRC_FILES		= $(shell find $(SRC_MAIN) -name "*.java")
TEST_FILES		= $(shell find $(SRC_TEST) -name "*.java")

SCENARIO		?= 

#------------------------------------------------------------------------------#
#   RECIPE                                                                     #
#------------------------------------------------------------------------------#

compile:
	mkdir -p $(OUT_DIR)
	javac -cp $(OUT_DIR) -d $(OUT_DIR) $(SRC_FILES)

compile-tests: compile
	mkdir -p $(OUT_TEST_DIR)
	javac -cp $(OUT_DIR) -d $(OUT_TEST_DIR) $(TEST_FILES)

run: compile
	java -cp $(OUT_DIR) $(MAIN_CLASS) $(SCENARIO)

run-tests: compile-tests
	java -cp $(OUT_DIR):$(OUT_TEST_DIR) $(TEST_MAIN_CLASS)

clean:
	rm -rf $(OUT_DIR) $(OUT_TEST_DIR)

re: clean run

re-test: clean run-tests
