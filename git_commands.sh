#!/bin/bash

# Get the list of modified (staged and unstaged) files
MODIFIED_FILES=$(git status -s | grep -E '^\s*[AM]' | awk '{print $2}' | tr '\n' ' ')

# If there are modified or untracked files
if [ -n "$MODIFIED_FILES" ]; then
  # Add all modified and untracked files to the staging area
  git add .

  # Commit with the modified/untracked files as the commit message
  git commit -m "Files changed: $MODIFIED_FILES"

  # Push changes to the remote repository
  git push
else
  echo "No files found to commit."
fi
