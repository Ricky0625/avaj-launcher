#------------------------------------------------------------------------------#
#   INGREDIENTS                                                                #
#------------------------------------------------------------------------------#

# Sources
SRC_DIR			:= src
SRC_MAIN		:= $(SRC_DIR)/main
SRC_TEST		:= $(SRC_DIR)/test
SRC_GENERATOR	:= $(SRC_DIR)/generator

# Output files (.class files) & simulation log
OUT_DIR			:= out
OUT_TEST_DIR	:= $(OUT_DIR)/test
OUT_GENERATOR	:= $(OUT_DIR)/generator
OUT_FILE		:= $(OUT_DIR)/simulation.txt

# Main
MAIN_CLASS		:= AvajLauncher
TEST_MAIN_CLASS	:= MainTestSuite
GENERATOR_CLASS	:= ScenarioGenerator

SRC_FILES		= $(shell find $(SRC_MAIN) -name "*.java")
TEST_FILES		= $(shell find $(SRC_TEST) -name "*.java")
GENERATOR_FILES	= $(shell find $(SRC_GENERATOR) -name "*.java")

SCENARIO		?= 
FLAGS			?=

#------------------------------------------------------------------------------#
#   RECIPE                                                                     #
#------------------------------------------------------------------------------#

compile:
	@mkdir -p $(OUT_DIR)
	@javac -cp $(OUT_DIR) -d $(OUT_DIR) $(SRC_FILES)

compile-tests: compile
	@mkdir -p $(OUT_TEST_DIR)
	@javac -cp $(OUT_DIR) -d $(OUT_TEST_DIR) $(TEST_FILES)

compile-generator: compile
	@mkdir -p $(OUT_GENERATOR)
	@javac -cp $(OUT_DIR) -d $(OUT_GENERATOR) $(GENERATOR_FILES)

run: print-main-art compile
	@java -cp $(OUT_DIR) $(MAIN_CLASS) $(SCENARIO)

log:
	@cat $(OUT_FILE)

tests: print-test-art compile-tests
	@java -cp $(OUT_DIR):$(OUT_TEST_DIR) $(TEST_MAIN_CLASS)

generate: print-generator-art compile-generator
	@java -cp $(OUT_DIR):$(OUT_GENERATOR) $(GENERATOR_CLASS) $(FLAGS)

clean:
	@rm -rf $(OUT_DIR) $(OUT_TEST_DIR)
	@echo "🧹 Deleted out/"

re: clean run

retest: clean tests

print-art: 
	@echo "           __"
	@echo "           \  \     _ _"
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

print-generator-art: print-art
	@echo '             GENERATOR'
	@echo
