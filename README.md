# cli-progress

Simple CLI progress bar that allows multiple bars

## Installation

`[cli-progress "0.1.0"]`

## Usage

Print to terminal:
```clojure
(let [bar1 (cli-progress/inc (cli-progress/bar 100 "bar1") 10)
	  bar2 (cli-progress/inc (cli-progress/bar 50 "bar2") 30)])
	(cli-progress/print bar1 bar2)
	(cli-progress/stop bar1 bar2)
```

Don't forget to call `cli-progress/stop` when you're done to position the cursor at the end of the console

Render as string:
```clojure
(cli-progress/render
	(cli-progress/inc (cli-progress/bar 100 "bar1") 10)
	(cli-progress/inc (cli-progress/bar 50 "bar2") 30))
```

## License

Copyright © 2020 João Galrito

MIT License