#!/usr/bin/env bash 

# ========================================
# Python virtual environment setup script
# Creates:
#   - .venv
#   - upgrade pip/tools
#   - installs youtube download packages
#   - installs common machine learning packages
#   - generates requirements file
#
# Usage:
#   chmod +x venv.sh
#   ./venv.sh
# ========================================

set -e # Exit immediately if a command exits with a non-zero status

# Configurable variables
VENV_NAME=".venv"

PROJECT_DIR="$(pwd)" # Get the current working directory ex: /home/user/my_project
PROJECT_NAME="$(basename "$PROJECT_DIR")" # Extract the project name from the directory path ex: my_project
PARENT_DIR="$(dirname "$PROJECT_DIR")" # Get the parent directory ex: /home/user

REQ_DIR="$PROJECT_DIR/config"  # Directory to store requirements files
REQ_FILE="$REQ_DIR/requirements.txt"  # Path to the requirements file

# Create Requirmements directory if it doesn't exist
mkdir -p "$REQ_DIR"

echo "=========================================="
echo "Project      : $PROJECT_NAME"
echo "Environment  : $VENV_NAME"
echo "Requirements : $REQ_FILE"
echo "=========================================="

# -------- Remove Broken Venv if Exists --------
if [ -d "$VENV_NAME" ]; then
    echo "[INFO] Existing virtual environment found."
    echo "[INFO] Removing old environment..."
    rm -rf "$VENV_NAME"
fi

# -------- Create Virtual Environment --------
echo "[INFO] Creating virtual environment..."
python3 -m venv "$VENV_NAME"

# -------- Activate Environment --------
echo "[INFO] Activating virtual environment..."
source "$VENV_NAME/bin/activate"

# -------- Upgrade Core Tools --------
echo "[INFO] Upgrading pip, setuptools, wheel..."

python -m pip install --upgrade \
    pip \
    setuptools \
    wheel

# -------- Install ML + Utility Packages --------
echo "[INFO] Installing required packages..."


pip install --upgrade \
    numpy \
    pandas \
    scikit-learn \
    matplotlib \
    yt-dlp \
    youtube-search-python

# -------- Install PyTorch CPU Only --------
echo "[INFO] Installing PyTorch (CPU only)..."

pip install --upgrade \
    torch \
    torchvision \
    torchaudio \
    --index-url https://download.pytorch.org/whl/cpu

# -------- Generate Requirements --------
echo "[INFO] Generating requirements.txt..."

pip freeze > "$REQ_FILE"

# -------- Final Output --------
echo ""
echo "=========================================="
echo "[SUCCESS] Environment setup completed."
echo ""
echo "To activate environment:"
echo "source $VENV_NAME/bin/activate"
echo ""
echo "Requirements saved to:"
echo "$REQ_FILE"
echo "=========================================="
