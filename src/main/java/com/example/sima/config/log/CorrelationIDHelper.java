package com.example.sima.config.log;

import brave.Span;
import brave.Tracer;
import brave.propagation.TraceContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CorrelationIDHelper {

    private final Tracer tracer;

    public CorrelationIDHelper(Tracer tracer) {
        this.tracer = tracer;
    }

    public String getCorrelationID() {
        return Optional.of(tracer).map(Tracer::currentSpan).map(Span::context).map(TraceContext::traceIdString).orElse("");
    }
}
