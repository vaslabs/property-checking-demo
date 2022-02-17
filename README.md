## Identifying properties to solve problems

- Updating state:
  - Inverse helps to undo things
  - Idempotency means the state doesn't change when
an identical command is sent twice to the system.
  - Commutative means you can break down the problem in pieces 
and process them in parallel


### Examples

#### Idempotency
One of the most important properties in modern applications:

- Introducing upsert when processing commands to insert rows in a database. 
  - If the row does not exist, an insert happens. 
  - if it does exist, overwrite the row.
  - A sharding protocol is needed to ensure the commands arrive in order.

#### Commutative
Important to have for cost calculations that can happen concurrently and
originate from different sources. Keeping the operations commutative
helps navigating potentially complex business rules.

#### The perfect operation
If the problem is reducible to a Min/Max problem you can do everything. It's
associative, commutative, idempotent and transitive. It's used in distributed
protocols like in the leader election algorithm in the Akka cluster (max on the ip address).