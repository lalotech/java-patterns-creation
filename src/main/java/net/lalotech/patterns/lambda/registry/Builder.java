package net.lalotech.patterns.lambda.registry;

import net.lalotech.patterns.lambda.factory.Factory;

public interface Builder<T> {
    void registry(String label, Factory<T> factory);
}
