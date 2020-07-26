package io.pillopl.testablearch.ex3.newmodel.lending.domain.patron;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
public class PatronId {

    @NonNull UUID uuid;
}
