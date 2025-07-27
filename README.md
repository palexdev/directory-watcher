### Description

This is a fork of the amazing work done by [Greg Methvin](https://github.com/gmethvin) on [Directory Wacther](https://github.com/gmethvin/directory-watcher), go start his project!.  
The only difference is that I don't like SLF4J and so I replaced it with [TinyLog](https://tinylog.org/).

### Versioning

I also changed the versioning system to the one I use for all my projects, it's basically [SemVer](https://semver.org/) but with a twist.
There's no patch version as the major is replaced for the minimum Java version required by the library so in `<a.b.c>`:
- `a` is the minimum Java version
- `b` is the major version
- `c` is the minor version