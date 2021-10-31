#!/bin/sh

# Decrypt the file

# --batch to prevent interactive command
# --yes to assume "yes" for questions
gpg --quiet --batch --yes --decrypt --passphrase="$NYC_API_KEY" \
--output ./api-key.txt api-key.txt.gpg