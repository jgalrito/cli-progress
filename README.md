# cli-progress

Simple CLI progress bar that allows multiple bars

## Installation

`[cli-progress "0.2.1"]`

## Usage

Print to terminal:
```clojure
(let [bar1 (cli-progress/bar 100 10 "bar1")
	  bar2 (cli-progress/bar 50 30 "bar2")])
	(cli-progress/print bar1 bar2)
	(cli-progress/stop bar1 bar2)
```

Don't forget to call `cli-progress/stop` when you're done to position the cursor at the end of the console

Render as string:
```clojure
(cli-progress/render
	(cli-progress/bar 100 10 "bar1")
	(cli-progress/bar 50 30 "bar2"))
```

## License

Copyright © 2020 João Galrito

MIT License