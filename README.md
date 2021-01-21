# webappx

A Clojure library designed to provide a basic ring server skeleton with just an one handler and no routing.
You can build upon this small project by adding reitit, hiccup etc.

## Usage

1. By running webappx.core namespace you get Jetty server running on localhost:3000
2. You can ``(.stop server)`` and ``(.start server)`` from a REPL
3. The last request is always saved in request-atom atom. 
