# Table 

## Overview

This Java program implements a custom hash table that organizes words from an input file into buckets based on a unique hash function. It demonstrates how hashing, 
collision handling, and duplicate detection work at a foundational level—without relying on Java’s built-in HashMap.

The program reads a file from the command line, creates Word objects for each line, inserts them into a 10-bucket table, removes duplicates, and prints the final table structure.

___

## Features

- Custom hashing algorithm:
  - Hashes words based on vowel count × word length mod 10.
- Manual hash table implementation:
  - Uses an array of ArrayList<Word> buckets.
- Duplicate removal:
  - Detects and removes duplicate Word objects using the custom equals() method.
- File input support:
  - Reads words line-by-line from any file passed through the CLI.
- Clear printed output:
  - Shows each bucket and the words stored inside.
- Error handling:
  - Gracefully alerts users when an invalid filename is provided.

___

## How It Works

- Initialization
  - The Table constructor creates an array of 10 ArrayList objects—each one serving as a bucket in the hash table.
- Reading the Input File
  - The program retrieves the filename from the command-line arguments.
  - It reads the file line-by-line using FileReader and Scanner.
  - Each line becomes a new Word object.
- Hashing and Inserting
  - Each Word object computes its hash code using:
    - (number of vowels × word length) % 10
  - This determines which bucket the word is placed in.
  - If the bucket does not already contain that word (based on .equals()), it is added.
- Removing Duplicates
  - After all words are inserted:
    - The program scans each bucket.
    - If adjacent words are equal, duplicates are removed.
- Output
  - The final table is printed in a bucket-by-bucket format, showing the organized data structure.
