package org.openapitools.server.model;

public class TagTypeAdapter
    implements javax.json.bind.adapter.JsonbAdapter<Tag, ImmutableTag> {

    @Override
    public ImmutableTag adaptToJson(Tag obj) throws Exception {
        return ImmutableTag.copyOf(obj);
    }

    @Override
    public Tag adaptFromJson(ImmutableTag obj) throws Exception {
        return obj;
    }
}
