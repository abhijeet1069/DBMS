#!/bin/bash

# Variables
H2_JAR_PATH="h2-2.3.232.jar" # Update this path to where your H2 jar file is located
DB_URL="jdbc:h2:~/testdb;DB_CLOSE_DELAY=-1" # In-memory database
DB_USER="sa"
DB_PASSWORD=""

# SQL script file
SQL_FILE="setup-h2.sql"

# Check if H2 jar exists
if [[ ! -f $H2_JAR_PATH ]]; then
    echo "H2 jar file not found! Please download and place it in the current directory."
    exit 1
fi

# Run the SQL script using H2
echo "Running SQL script..."
java -cp "$H2_JAR_PATH" org.h2.tools.RunScript -url "$DB_URL" -user "$DB_USER" -password "$DB_PASSWORD" -script "$SQL_FILE"

# Start H2 Shell for interactive queries
read -p "Do you want to run SQL queries interactively in H2 Shell? (y/n): " start_shell
if [[ $start_shell == "y" || $start_shell == "Y" ]]; then
    echo "Starting H2 Shell..."
    java -cp "$H2_JAR_PATH" org.h2.tools.Shell -url "$DB_URL" -user "$DB_USER" -password "$DB_PASSWORD"
else
    echo "Skipping H2 Shell."
fi
