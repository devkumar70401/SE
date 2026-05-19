#!/usr/bin/env bash

set -e

# ==========================================================
# FIND SCRIPT LOCATION
# ==========================================================

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

# Repository root. This script lives in scripts/utilities.
BASE_DIR="$(cd "$SCRIPT_DIR/../.." && pwd)"

# ----------------------------------------------------------
# BACKUP DIRECTORY
# ----------------------------------------------------------

BACKUP_DIR="$BASE_DIR/archive/backups"

# Timestamp
TIMESTAMP=$(date +"%Y-%m-%d_%H-%M-%S")

FINAL_BACKUP="$BACKUP_DIR/$TIMESTAMP"

mkdir -p "$FINAL_BACKUP"

echo "=================================================="
echo "Creating Backup..."
echo "=================================================="

echo
echo "Base Directory:"
echo "$BASE_DIR"

echo
echo "Backup Location:"
echo "$FINAL_BACKUP"

# ----------------------------------------------------------
# PYTHON REQUIREMENTS
# ----------------------------------------------------------

echo
echo "Saving requirements.txt..."

if command -v pip &> /dev/null; then
    pip freeze > "$FINAL_BACKUP/requirements.txt" || true
fi

# ----------------------------------------------------------
# VSCODE EXTENSIONS
# ----------------------------------------------------------

echo
echo "Saving VSCode extensions..."

if command -v code &> /dev/null; then
    code --list-extensions > "$FINAL_BACKUP/vscode_extensions.txt" || true
fi

# ----------------------------------------------------------
# BASH CONFIG
# ----------------------------------------------------------

echo
echo "Backing up shell configs..."

cp ~/.bashrc "$FINAL_BACKUP/.bashrc" 2>/dev/null || true
cp ~/.bash_aliases "$FINAL_BACKUP/.bash_aliases" 2>/dev/null || true
cp ~/.profile "$FINAL_BACKUP/.profile" 2>/dev/null || true
cp ~/.zshrc "$FINAL_BACKUP/.zshrc" 2>/dev/null || true

# ----------------------------------------------------------
# VSCODE SETTINGS
# ----------------------------------------------------------

echo
echo "Backing up VSCode settings..."

VSCODE_USER_DIR="$HOME/.config/Code/User"

mkdir -p "$FINAL_BACKUP/vscode"

cp "$VSCODE_USER_DIR/settings.json" \
   "$FINAL_BACKUP/vscode/" 2>/dev/null || true

cp "$VSCODE_USER_DIR/keybindings.json" \
   "$FINAL_BACKUP/vscode/" 2>/dev/null || true

# ----------------------------------------------------------
# VSCODE SNIPPETS
# ----------------------------------------------------------

echo
echo "Backing up VSCode snippets..."

if [ -d "$VSCODE_USER_DIR/snippets" ]; then
    cp -r "$VSCODE_USER_DIR/snippets" \
          "$FINAL_BACKUP/vscode/"
fi

# ----------------------------------------------------------
# INSTALLED SYSTEM PACKAGES
# ----------------------------------------------------------

echo
echo "Saving installed package list..."

dpkg --get-selections > \
    "$FINAL_BACKUP/installed_packages.txt" 2>/dev/null || true

# ----------------------------------------------------------
# GIT CONFIG
# ----------------------------------------------------------

echo
echo "Backing up git config..."

cp ~/.gitconfig "$FINAL_BACKUP/.gitconfig" 2>/dev/null || true

# ----------------------------------------------------------
# ENVIRONMENT VARIABLES
# ----------------------------------------------------------

echo
echo "Saving environment variables..."

printenv > "$FINAL_BACKUP/environment_variables.txt"

# ----------------------------------------------------------
# OPTIONAL: CURRENT DIRECTORY TREE
# ----------------------------------------------------------

echo
echo "Saving project structure..."

if command -v tree &> /dev/null; then
    tree -a -I '.git|node_modules|.venv|__pycache__' \
        > "$FINAL_BACKUP/project_tree.txt" || true
fi

# ----------------------------------------------------------
# FINISHED
# ----------------------------------------------------------

echo
echo "=================================================="
echo "BACKUP COMPLETE"
echo "Saved to:"
echo "$FINAL_BACKUP"
echo "=================================================="
