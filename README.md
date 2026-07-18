# aburi (炙り)

Standalone Etzhayyim observatory that lets a member inspect tracking exposure
from their own consented local exports and representative public catalogue data.
It stores exposure structure, not credentials or raw identifiers, and never
profiles another person.

EDN metadata, schema, and representative seed are canonical. External DID JSON
is isolated under `wire/`. Runtime code and tests live under `src/aburi` and
`test/aburi`. Run the comprehensive suite with `bb test`.

Python twins, Go/TinyGo, wasm wrappers, shell runners, and legacy JSON-LD
manifests are prohibited.
