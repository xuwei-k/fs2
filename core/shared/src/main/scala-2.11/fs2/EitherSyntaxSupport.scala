package fs2

private[fs2] trait EitherSyntaxSupport {
  // Trick to get right-biased syntax for Either in 2.11 while retaining source compatibility with 2.12 and leaving
  // -Xfatal-warnings and -Xwarn-unused-imports enabled. Delete when no longer supporting 2.11.
  private[fs2] implicit def eitherSyntax[L,R](self: Either[L,R]): EitherSyntax[L,R] =
    new EitherSyntax(self)
}

private[fs2] class EitherSyntax[L,R](private val self: Either[L,R]) extends AnyVal {
  def map[R2](f: R => R2): Either[L,R2] = self match {
    case Right(r) => Right(f(r))
    case l @ Left(_) => l.asInstanceOf[Either[L,R2]]
  }
  def flatMap[R2](f: R => Either[L,R2]): Either[L,R2] = self match {
    case Right(r) => f(r)
    case l @ Left(_) => l.asInstanceOf[Either[L,R2]]
  }
  def toOption: Option[R] = self match {
    case Right(r) => Some(r)
    case l @ Left(_) => None
  }
}
