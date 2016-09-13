package object fs2 extends EitherSyntaxSupport {

  /**
   * A stream transformation represented as a function from stream to stream.
   *
   * Pipes are typically applied with the `through` operation on `Stream`.
   */
  type Pipe[F[_],-I,+O] = Stream[F,I] => Stream[F,O]

  /**
   * A stream transformation that combines two streams in to a single stream,
   * represented as a function from two streams to a single stream.
   *
   * `Pipe2`s are typically applied with the `through2` operation on `Stream`.
   */
  type Pipe2[F[_],-I,-I2,+O] = (Stream[F,I], Stream[F,I2]) => Stream[F,O]

  /**
   * A pipe that converts a stream to a `Stream[F,Unit]`.
   *
   * Sinks are typically applied with the `to` operation on `Stream`.
   */
  type Sink[F[_],-I] = Pipe[F,I,Unit]
}
