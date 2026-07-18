# aburi repository guidance

Keep EDN canonical and external JSON under `wire/`. Preserve own-data-only,
edge-primary, non-adjudicating, reciprocity-restoring, local-only, no-credential,
no-raw-identifier, passive-ingest, and outward-gated invariants. Never commit
member exports under `data/local/`. Do not restore Python twins, Go/TinyGo, wasm
wrappers, former root paths, or shell runners. Verify with `bb test` and audits.
