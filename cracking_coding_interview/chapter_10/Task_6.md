# Sort Big File

Imagine you have a 20 GB file with one string per line. Explain how you would sort the file.

## Solution

* Split file on chunks, save it on disk
* Sort each chunks individually, store sorted result to disk
* Merge all chunks in result file. Using merge sort (k way) and reading from file small amount of data.

Keyword: external sort 