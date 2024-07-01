import React from "react";
import Head from "next/head";
import dynamic from "next/dynamic";
import Link from "next/link";

const App = dynamic(() => import("../components/App"), { ssr: false });

export default function Home() {
    return (
        <>
            <Head>
                <title>Bliss Body</title>
                <meta name="description" content="Generated by create next app" />
                <link rel="icon" href="/favicon.ico" />
            </Head>
            <Link href="/login"> Go to login page !</Link>
        </>
    );
}
