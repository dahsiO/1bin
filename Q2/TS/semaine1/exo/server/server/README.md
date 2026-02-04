# BINV1051B web 1 solutions Hospital Server

## Introduction

This folder contains the source of an simple Node server in Typescript. This is used as an evolutive exercice for the class. Among the weeks we are going to code in this environment.

## How to start

The source code is written in Typescript, following it must be transpilled into Javascript before the execution happens.

### Transpilation TS->JS

In the main folder use the commande

```bash
npm run build
```

This will procude a new folder "exec" containing the JS code. Note that this command uses the `-w` flag and will watche for changes in the "src" folder and automatically transforms the TS code into JS.

### Execution

The actually run the server you must run the command in the main folder.

```bash
npm run dev
```

This command uses the `-w` flag and the server will restart at any changes in the "exec" folder. To start the server without this behaviour, use the command

```bash
npm run start
```

## Architecture

The entrance of the code is the 'main.ts' script that will actually run the server.
