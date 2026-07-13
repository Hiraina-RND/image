package hei.prog.app.file.hash;

import hei.prog.app.PojaGenerated;

@PojaGenerated
public record FileHash(FileHashAlgorithm algorithm, String value) {}
