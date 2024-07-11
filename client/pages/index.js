import React from "react";
import Head from "next/head";
import dynamic from "next/dynamic";
import Link from "next/link";
import '../styles/globals.css';

const App = dynamic(() => import("../components/App"), { ssr: false });

export default function Home() {
    return (
        <>
            <Head>
                <title>Bliss Body</title>
                <meta name="description" content="Generated by create next app" />
                <link rel="icon" href="/favicon.ico" />
                <link rel="preconnect" href="https://fonts.googleapis.com" />
                <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
                <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet" />
            </Head>
            <Link href="/login"> Go to login page !</Link>
        </>
    );
}
