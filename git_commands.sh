#!/bin/bash

# Get the list of modified files that are staged or unstaged for commit
MODIFIED_FILES=$(git status -s | grep -E '^\s*M' | awk '{print $2}' | tr '\n' ' ')

# If there are modified files
if [ -n "$MODIFIED_FILES" ]; then
  # Add all modified files to the staging area
  git add .

  # Commit with the modified files as the commit message
  git commit -m "Modified files: $MODIFIED_FILES"

  # Push changes to the remote repository
  git push
else
  echo "No modified files found to commit."
fi
