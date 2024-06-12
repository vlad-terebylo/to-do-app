package com.tvo.model;

import com.tvo.exception.CannotUpdateStatusException;

public enum TaskStatus {
    TO_DO {
        @Override
        public TaskStatus next() {
            return IN_PROGRESS;
        }
    },
    IN_PROGRESS {
        @Override
        public TaskStatus next() {
            return COMPLETED;
        }
    },
    COMPLETED {
        @Override
        public TaskStatus next() {
            throw new CannotUpdateStatusException("It is the max status of your task");
        }
    };

    public TaskStatus next() {
        throw new UnsupportedOperationException();
    }
}
