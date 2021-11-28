#!/bin/sh

# Decrypt the file
# --batch to prevent interactive command
# --yes to assume "yes" for questions
gpg --quiet --batch --yes --decrypt --passphrase="$FIREBASE_FILE_KEY2" \
--output ./spring-project-3-firebase-adminsdk-dang2-d8fc83122b.json spring-project-3-firebase-adminsdk-dang2-d8fc83122b.json.gpg