# Variáveis de compilação
JAVAC = javac
JAVA = java
MAIN_CLASS = Menu

# Diretórios
SRC_DIR = .
BIN_DIR = bin

# Encontrar arquivos fonte
SOURCES := $(wildcard $(SRC_DIR)/**/*.java)

# Transformar arquivos fonte em arquivos objeto
CLASSES := $(patsubst %.java, $(BIN_DIR)/%.class, $(notdir $(SOURCES)))

# Comando para compilar
COMPILE = $(JAVAC) -d $(BIN_DIR) $^

# Comando para executar
EXECUTE = $(JAVA) -cp $(BIN_DIR) $(MAIN_CLASS)

# Regras
all: $(CLASSES)

$(BIN_DIR)/%.class: $(SRC_DIR)/**/*.java
	@mkdir -p $(BIN_DIR)
	$(COMPILE)

run:
	$(EXECUTE)

clean:
	rm -rf $(BIN_DIR)

# Regra para executar o programa da conta bancária
account:
	$(JAVA) -cp $(BIN_DIR) conta.Menu

# Regra phony para forçar a execução mesmo que exista um arquivo com o mesmo nome
.PHONY: all clean fclean re account
