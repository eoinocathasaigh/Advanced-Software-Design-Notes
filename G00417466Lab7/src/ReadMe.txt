Use of Lambda expressions as command objects and use of generics for reusing data structures

Lambda expressions let us pass behaviour around as if it were data, instead of creating a whole class to represent a “command” or an action, you can express it as a simple inline function.
Makes callback/reuse code much easier to read, they help capture operations we want to run and then hand it off to other programs

Generics for reuse
Generics allow us to make/write a data structure like a map, list or collection and reuse it for any type needed
Instead of building new version of structure for ints, strings etc we write it once and plug it into whatever type. This reuse helps keep things flexible in our code
Helps us to avoid sacrificing clarity and unnecessary casting