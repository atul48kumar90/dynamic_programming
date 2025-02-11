#!/bin/bash

# Get the name of the most recent modified file
FILE_NAME=$(ls -t | head -n 1)

# If there are files to commit
if [ -n "$FILE_NAME" ]; then
  # Add changes to git
  git add .

  # Commit with the file name as the commit message
  git commit -m "$FILE_NAME"

  # Push changes to the remote repository
  git push
else
  echo "No files found to commit."
fi
