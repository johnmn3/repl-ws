# repl-ws

A simple example showing how to use socket repls with cljs.repl.ws

## Setup

First, `git clone` this repo...

Then, cd into the project directory and compile client code:

`clj -m cljs.main -c repl-ws.ex`

Then, launch a socket repl:

`clj -J-Dclojure.server.repl="{:port 5555 :accept cljs.server.ws/repl}"`

Then, in another terminal, connect:

```
 $ rlwrap nc localhost 5555
Waiting for connection at ws://localhost:9001 ...
```

Then, in a browser, load _the actual file_:

`open ./index.html`

The second terminal prompt should return:

```
 $ rlwrap nc localhost 5555
Waiting for connection at ws://localhost:9001 ...
ClojureScript 1.10.XXX
cljs.user=>
```

Print to the browser:

```
cljs.user=> (js/console.log "hi")
nil
```

Check the browser and you should see the "hi" in the console.

Now open another tab with same file. You'll see information added to the terminal:

```
new repl client: :repl.ws/=>2
cljs.user:1=>
```

Evaluate `:repl.ws/=>2` at the repl to switch the repl to the new client:

```
cljs.user=> :repl.ws/=>2
switching to client: 2
nil
cljs.user:2=>
```

Console printing will now show up in the second browser window.

Now, open a third terminal and connect to the socket server again.

```
$ rlwrap nc localhost 5555
ClojureScript 1.10.XXX
cljs.user=>
cljs.user=> (js/console.log "hi")
nil
```

## Overview

This does not do state management on browser reload.
