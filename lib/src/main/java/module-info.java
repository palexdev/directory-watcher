module directory.watcher {
    /* Dependencies */
    requires com.sun.jna;
    requires jdk.unsupported;
    requires org.tinylog.api;

    /* Exports */
    exports io.github.palexdev.watcher;
    exports io.github.palexdev.watcher.changeset;
    exports io.github.palexdev.watcher.hashing;
    exports io.github.palexdev.watcher.visitor;

    exports io.github.palexdev.watchservice;
    exports io.github.palexdev.watchservice.jna;
}