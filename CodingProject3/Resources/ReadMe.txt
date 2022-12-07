1. The Hashfunction that I used is called the polynomial roling hash function (Reference: https://cp-algorithms.com/string/string-hashing.html), 
but I modified it a little bit by after performing the polynomial rolling hashfunction I then squared the value and then moded it with the table size.

2. Advantages: Speed is the main advantage compared to other data structures and it becomes more apparent when the number of values to be stored goes up, with a perfect hash function searching, adding and removing can be become constant time on average.

Disadvantages: Most likely when it comes to hash functions it is very hard to find a perfect hash function so collisions will happen and with out a good hash function the table becomes quite inneficient due to the many collisons,
So a really good hash function is key to hashing.

Application: One application I found is password verification, when you are trying to login to a website account and you enter a password they use a hash function called a cryptographic hash function to turn hash your password and then send it to the server to
verify it. The passwords stored on their server are just computed hash values which they compare to your entered password to the servers stored password for your account. This is done so when the password is sent to the server people cant get your password.

3. The amount of time I spent on this project was about 7 hours. The biggest challenge I faced was figuring out how to create a hashfunction that would be faster or equally as fast as Java string hashing function. I got it down to the fastest I could get it but it wasnt faster then javas 
but mine did have less collisons, so I think function for computing the index was slower but I couldnt find one that was faster and would create less collisons. I did kinda overcome the challenge because my initial function did have like 1 million collissions and took a whole second for runtime and
I was able to get that down to about 16,000 collisons and only .11 of a second for runtime.
