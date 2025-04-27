package com.exercise.coincounter;

import lombok.Builder;

@Builder
public record CounterResult(int type, int value) {
}
