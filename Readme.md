# Domain Specific Search Engine

This project allows you to search a specified web domain (ex. cnn.com) for a search query. It will return the top 10 results with most hits for that query string. 

This takes as input the specified domain, as well a search string parameter. From that, it crawls the domain, building a FIFO queue of links to parse (stored via a doubly linked list), until a limit is reached. Each link is then parsed using jsoup, and sequentially ranked by number of hits with the search query parameters. 

Multithreading was later incorporated into this project to improve processing speed. The index range of the links queue is divided amongst the threads, which then parse concurrently. This eliminates error of duplicate processing of a link.

This project was built in collaboration with Riley Turk, for Intro to Java Programming at Purdue. March 2017.