#------------------------------------------------------------------------------#
#   INGREDIENTS                                                                #
#------------------------------------------------------------------------------#

# Sources
SRC_MAIN		:= src/main
SRC_TEST		:= src/test

# Output files (.class files)
OUT_DIR			:= out
OUT_TEST_DIR	:= out/test

# Main
MAIN_CLASS		:= AvajLauncher
TEST_MAIN_CLASS	:= MainTestSuite

SRC_FILES		= $(shell find $(SRC_MAIN) -name "*.java")
TEST_FILES		= $(shell find $(SRC_TEST) -name "*.java")

SCENARIO		?= 

#------------------------------------------------------------------------------#
#   RECIPE                                                                     #
#------------------------------------------------------------------------------#

compile:
	@mkdir -p $(OUT_DIR)
	@javac -cp $(OUT_DIR) -d $(OUT_DIR) $(SRC_FILES)

compile-tests: compile
	@mkdir -p $(OUT_TEST_DIR)
	@javac -cp $(OUT_DIR) -d $(OUT_TEST_DIR) $(TEST_FILES)

run: print-main-art compile
	@java -cp $(OUT_DIR) $(MAIN_CLASS) $(SCENARIO)

tests: print-test-art compile-tests
	@java -cp $(OUT_DIR):$(OUT_TEST_DIR) $(TEST_MAIN_CLASS)

clean:
	@rm -rf $(OUT_DIR) $(OUT_TEST_DIR)
	@echo "🧹 Deleted out/"

re: clean run

retest: clean tests

print-art: 
	@echo "            __"
	@echo "            \  \     _ _"
	@echo "            \\**\\ ___\\/ \\"
	@echo "          X*#####*+^^\\__\\"
	@echo "            o/\\  \\"
	@echo "               \\__\\"
	@echo "           AVAJ_LAUNCHER"

print-main-art: print-art
	@echo '               [MAIN]'
	@echo

print-test-art: print-art
	@echo '               [TEST]'
	@echo
