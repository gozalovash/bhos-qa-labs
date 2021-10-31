#!/bin/sh

# Decrypt the file
# --batch to prevent interactive command
# --yes to assume "yes" for questions
gpg --quiet --batch --yes --decrypt --passphrase="$FIREBASE_FILE_KEY" \
--output ./spring-project-3-firebase-adminsdk-dang2-734dba00f4.json spring-project-3-firebase-adminsdk-dang2-734dba00f4.json.gpg